import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


/** 
 *The class creates a window with 
 *the ability to copy information
 * 
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
		shell.setSize(CONSTANTS.WINDOW_WIGTH,CONSTANTS.WINDOW_HEIGHT);
		
		GridLayout gridLayout = new GridLayout(3, true);
		gridLayout.makeColumnsEqualWidth = false;
		shell.setLayout(gridLayout);
		
		
	    Composite firstColomnComposite = new Composite(shell,SWT.NONE);
	    
		RowLayout firstColomnLayout = new RowLayout();
		firstColomnLayout.type = SWT.VERTICAL;
		firstColomnLayout.spacing = CONSTANTS.SPACING_BEETWEN_ELEMENTS;
		firstColomnComposite.setLayout(firstColomnLayout);
		
		firstText = new Text(firstColomnComposite, SWT.NONE);
		firstText.setLayoutData(new RowData(CONSTANTS.TEXT_WEIGTH,CONSTANTS.TEXT_HEIGHT));
		
		buttonCopy1to2 = new Button(firstColomnComposite, SWT.PUSH);
		buttonCopy1to2.setLayoutData(new RowData(CONSTANTS.BUTTON_WEIGTH,CONSTANTS.BUTTON_HEIGHT));
		buttonCopy1to2.setText("Copy 1 to 2");
		
		
		
		Composite secondColomnComposite = new Composite(shell,SWT.NONE);
		
		RowLayout secondColomnLayout = new RowLayout();
		secondColomnLayout.type = SWT.VERTICAL;
		secondColomnLayout.spacing = CONSTANTS.SPACING_BEETWEN_ELEMENTS;
		secondColomnComposite.setLayout(secondColomnLayout);
		
		secondText = new Text(secondColomnComposite, SWT.NONE);
		secondText.setLayoutData(new RowData(CONSTANTS.TEXT_WEIGTH,CONSTANTS.TEXT_HEIGHT));	
		
		buttonCopy2to3 = new Button(secondColomnComposite, SWT.PUSH);
		buttonCopy2to3.setLayoutData(new RowData(CONSTANTS.BUTTON_WEIGTH,CONSTANTS.BUTTON_HEIGHT));
		buttonCopy2to3.setText("Copy 2 to 3");
		
		
		
		Composite thirdColomnComposite = new Composite(shell,SWT.NONE);
		
		RowLayout thirdColomnLayout = new RowLayout();
		thirdColomnLayout.type = SWT.VERTICAL;
		thirdColomnLayout.spacing = CONSTANTS.SPACING_BEETWEN_ELEMENTS;
		thirdColomnLayout.marginBottom = 42;
		thirdColomnComposite.setLayout(thirdColomnLayout);
		thirdText = new Text(thirdColomnComposite, SWT.NONE);
		thirdText.setLayoutData(new RowData(CONSTANTS.TEXT_WEIGTH,CONSTANTS.TEXT_HEIGHT));
		
		/**@see App#setButtonEvent(Button, Text, Text)*/
		setButtonEvent(buttonCopy1to2, firstText, secondText);
		setButtonEvent(buttonCopy2to3, secondText, thirdText);
		
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
     * @return Nothing.
    */
	private void setButtonEvent(Button btn,Text from,Text to)	{
		btn.addListener(SWT.Selection,new Listener(){
			@Override
			public void handleEvent(Event e)
			{
				to.setText(from.getText());
			}
		});
	}
	
	/** The main method where the window object is created
	 * @param args - arguments from command line.
	 * @return Nothing.
	 */
	public static void main(final String[] args) {
		new App();
	}

}
