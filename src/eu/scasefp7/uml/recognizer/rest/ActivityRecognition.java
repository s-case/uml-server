package eu.scasefp7.uml.recognizer.rest;

import com.sun.jersey.multipart.BodyPartEntity;
import com.sun.jersey.multipart.MultiPart;

import eu.scasefp7.uml.recognizer.UMLRecognizer;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Path("/activity")
public class ActivityRecognition {
	@POST
	@Consumes("multipart/mixed")
	public Response post(MultiPart multiPart) {
		String xmi = "";
		// First part contains a Project object
		Image image = multiPart.getBodyParts().get(0).getEntityAs(Image.class);
		// System.out.println("name : " + project.getName());
		// System.out.println("description : " + project.getDescription());
		// System.out.println("license : " + project.getLicense());
		// System.out.println("SVN URL : " + project.getSvnURL());
		// System.out.println("homepage : " + project.getHomePage());

		// get the second part which is the project logo
		BodyPartEntity bpe = (BodyPartEntity) multiPart.getBodyParts().get(1).getEntity();
		String id = UUID.randomUUID().toString();
		boolean isProcessed = false;
		String message = null;
		try {
			InputStream source = bpe.getInputStream();
			BufferedImage bi = ImageIO.read(source);

			File file = new File("/home/UMLServer/ImageFiles/" + id + ".png");
			if (file.exists())
				file.delete();
			// storing the image to file system.
			if (file.isDirectory()) {
				ImageIO.write(bi, image.getFormat(), file);
			} else {
				file.mkdirs();
				ImageIO.write(bi, image.getFormat(), file);
			}

			UMLRecognizer recognizer = new UMLRecognizer();
			recognizer.setImage(file.getAbsolutePath());
			recognizer.setTessPath("/home/UMLServer/tessdata");
			recognizer.setParameters(false, false, image.getImageThreshold(), image.getRectangleRate(), image.getMinDistance(), image.getMinRate());
			recognizer.process();
			for(int i=0;i<recognizer.getXMIcontent().size();i++)
				xmi=xmi+recognizer.getXMIcontent().get(i)+"\n";
			
			isProcessed = true;

		} catch (Exception e) {
			message = e.getMessage();
		}
		if (isProcessed) {
			return Response.status(Response.Status.ACCEPTED).entity(xmi).type(MediaType.APPLICATION_XML).build();
		}

		return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
				.entity("Failed to process UML Image. Reason : " + message).type(MediaType.TEXT_PLAIN).build();
	}

}
