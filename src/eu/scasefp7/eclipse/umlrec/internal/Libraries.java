package eu.scasefp7.eclipse.umlrec.internal;



public class Libraries  {
	//private static final String BUNDLE_NAME = "eu.scasefp7.eclipse.umlrec.internal.libraries"; //$NON-NLS-1$
	public static String UMLRecognizerJNI_LibrariesList;
	public static String UMLRecognizerJNI_Separator;
	static {
		// initialize resource bundle
		//NLS.initializeMessages(BUNDLE_NAME, Libraries.class);
		UMLRecognizerJNI_LibrariesList="lept,tesseract,opencv_core,opencv_highgui,opencv_imgproc,UMLrecogn";
		UMLRecognizerJNI_Separator=",";
	}

	private Libraries() {
	}
}
