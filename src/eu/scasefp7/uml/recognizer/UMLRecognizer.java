package eu.scasefp7.uml.recognizer;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import eu.scasefp7.eclipse.umlrec.internal.UMLrecog;

public class UMLRecognizer {
	
	private static final String RECOGNIZER_DATA = "tessdata";
	
	/** Reference to the wrapped uml recognizer object */
	protected UMLrecog _umlRec = null;
	
	/** Store the image file name */
	protected String _fileName = null;
	
	/** Store the tesseract recognizer files */
	protected String _tessData = null;
	
	public static final boolean SHOW_IMAGES=false;
	public static final int THRESH=230;
	public static final double SIZE_RATE=1.0;
	public static final double DIST_NEIGHBOR_OBJECTS=20.0;
	public static final double COVER_AREA_THR=1.0;

	/**
	 * 
	 */
	public UMLRecognizer() throws MissingRecognizerNativeException {
		this._umlRec = new UMLrecog();
		
	
		try {
			
			this._tessData = "/home/UMLServer/tessdata";
			this._umlRec.setTessPath(this._tessData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clear() {
		this._umlRec.clear();
	}
	
	public void setImage(String fileName) throws RecognitionException {
		// The setImage function returns true if it succeeded to load the image, otherwise false.
		this._fileName = fileName;
		boolean res = this._umlRec.setImage(fileName);
		
		if(res == false) {
			throw new RecognitionException("Failed to load the image file " + fileName); //$NON-NLS-1$
		} 
	}
	
	public void process() throws MissingRecognizerDataException, RecognitionException {
		// The process function returns 
		// 	0 for a successful run, 
		//	-2 if TessData files are missing OR the program failed to analyse the text of the diagram and 
		// 	-1 if an unknown error occurred.
		
		int result = this._umlRec.process();

		if(result == -2) {
			throw new MissingRecognizerDataException("Missing tessdata files or text analysis failed"); //$NON-NLS-1$
		}
		
		if(result == -1) {
			throw new RecognitionException("Unknown recognition error"); //$NON-NLS-1$
		}
			
		return;
	}
	
	public List<String> getXMIcontent() {
		return this._umlRec.getXMIcontent();
	}
	
	public void setTessPath(String pathName) {
		this._umlRec.setTessPath(pathName);
	}
	
	public void setParameters(boolean isUseCase, boolean showImages, int thresh, double sizeRate, double distNeightborObjects, double coverAreaThr) {
		this._umlRec.setParameters(isUseCase, showImages, thresh, sizeRate, distNeightborObjects, coverAreaThr);
	}

}
