import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

 /**
  *The class creates a window with 
  *the ability to copy information
  * @version 1.0
  * @author Maxim
  * @since 2018-02-28
  */

public class App {
	/**Property - to copy Text from 1 field to 2 field.*/
	private Button buttonCopy1to2;
	/** @see App#copy1to2*/
	private Button buttonCopy2to3;
	/**Property - field for input text.*/
	private Text firstText;
	/**@see App#firstText*/
	private Text secondText;
	/**@see App#firstText*/
	private Text thirdText;
	/**Constructor - creating a new object.*/
	public App() {
		Display display = new Display();

		final Shell shell = new Shell(display);
		
		shell.setText("Copy manager");
		shell.setSize(CONSTANTS.WINDOW_WIDTH,CONSTANTS.WINDOW_HEIGHT);
		
		GridLayout gridLayout = new GridLayout(CONSTANTS.NUM_COL, false);
		shell.setLayout(gridLayout);
		
		
	    Composite firstColomnComposite = new Composite(shell,SWT.NONE);
	    
		RowLayout firstColomnLayout = new RowLayout();
		firstColomnLayout.type = SWT.VERTICAL;
		firstColomnLayout.spacing = CONSTANTS.SPACING_BETWEEN_ELEMENTS;
		firstColomnComposite.setLayout(firstColomnLayout);
		
		firstText = new Text(firstColomnComposite, SWT.NONE);
		firstText.setLayoutData(new RowData(CONSTANTS.TEXT_WEIDTH,CONSTANTS.TEXT_HEIGHT));
		
		buttonCopy1to2 = new Button(firstColomnComposite, SWT.PUSH);
		buttonCopy1to2.setLayoutData(new RowData(CONSTANTS.BUTTON_WEIDTH,CONSTANTS.BUTTON_HEIGHT));
		buttonCopy1to2.setText("Copy 1 to 2");
		
		
		
		Composite secondColomnComposite = new Composite(shell,SWT.NONE);
		
		RowLayout secondColomnLayout = new RowLayout();
		secondColomnLayout.type = SWT.VERTICAL;
		secondColomnLayout.spacing = CONSTANTS.SPACING_BETWEEN_ELEMENTS;
		secondColomnComposite.setLayout(secondColomnLayout);
		
		secondText = new Text(secondColomnComposite, SWT.NONE);
		secondText.setLayoutData(new RowData(CONSTANTS.TEXT_WEIDTH,CONSTANTS.TEXT_HEIGHT));	
		
		buttonCopy2to3 = new Button(secondColomnComposite, SWT.PUSH);
		buttonCopy2to3.setLayoutData(new RowData(CONSTANTS.BUTTON_WEIDTH,CONSTANTS.BUTTON_HEIGHT));
		buttonCopy2to3.setText("Copy 2 to 3");
		
		
		
		Composite thirdColomnComposite = new Composite(shell,SWT.NONE);
		
		RowLayout thirdColomnLayout = new RowLayout();
		thirdColomnLayout.type = SWT.VERTICAL;
		thirdColomnLayout.spacing = CONSTANTS.SPACING_BETWEEN_ELEMENTS;
		thirdColomnLayout.marginBottom = CONSTANTS.MARGIN_BOTTON;
		thirdColomnComposite.setLayout(thirdColomnLayout);
		thirdText = new Text(thirdColomnComposite, SWT.NONE);
		thirdText.setLayoutData(new RowData(CONSTANTS.TEXT_WEIDTH,CONSTANTS.TEXT_HEIGHT));
		
		/**@see App#setButtonEvent(Button, Text, Text)*/
		setButtonEvent(buttonCopy1to2, firstText, secondText);
		setButtonEvent(buttonCopy2to3, secondText, thirdText);
		
		shell.pack();
		shell.open();

	    while (!shell.isDisposed()) {
	    	if (!display.readAndDispatch()) {
	                display.sleep();
	        }
	    } 

		display.dispose();

	}
	
	/** Assigns an event to the button.
     * @param btn - that button which assigned event.
     * @param from - text from where the information was copied.
     * @param to - text in which the copied information will be.
    */
	private void setButtonEvent(final Button btn,final Text from,final Text to)	{
		
		btn.addMouseTrackListener(new MouseTrackListener() {
			
			@Override
			public void mouseHover(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExit(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEnter(MouseEvent arg0) {
				// TODO Auto-generated method stub
				to.setText(from.getText());
			}
		});
	}
	
	/** The main method where the window object is created
	 * @param args - arguments from command line.
	 */
	public static void main(final String[] args) {
		new App();
	}

}
