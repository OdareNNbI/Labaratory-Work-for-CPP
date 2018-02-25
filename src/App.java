import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class App {

final static int sizeX = 300;
final static int sizeY = 150;
final static int sizeTextX = 70;
final static int sizeTextY = 15;
final static int sizeButtonX = 70;
final static int sizeButtonY = 30;
final static int distance = 15;
final static int posYForText = 10;


public static void main(String args[]) {
	Display display = new Display();
	final Shell shell = new Shell(display);
	shell.setSize(sizeX, sizeY);
	GridLayout layout  =  new GridLayout();
	layout.numColumns = 3;
	shell.setLayout(layout);
	
	Text text1 = new Text(shell,SWT.CENTER);
	text1.setSize(sizeTextX,sizeTextY);
	text1.setLocation(distance, posYForText);

	Text text2 = new Text(shell,SWT.CENTER);
	text2.setSize(sizeTextX,sizeTextY);
	text2.setLocation(text1.getLocation().x + sizeTextX + distance, posYForText);
	
	Text text3 = new Text(shell,SWT.CENTER);
	text3.setSize(sizeTextX,sizeTextY);
	text3.setLocation(text2.getLocation().x + sizeTextX + distance, posYForText);
	
	
	

	Button copy1to2 = new Button(shell,SWT.CENTER);
	copy1to2.setSize(sizeButtonX, sizeButtonY);
	copy1to2.setLocation(text1.getLocation().x, text1.getLocation().y + distance * 2);
	copy1to2.setText("Copy 1 to 2");
	
	Button copy2to3 = new Button(shell,SWT.CENTER);
	copy2to3.setSize(sizeButtonX, sizeButtonY);
	copy2to3.setLocation(text2.getLocation().x, text2.getLocation().y + distance * 2);
	copy2to3.setText("Copy 2 in 3");
	
	
	
		
	

	copy1to2.addListener(SWT.Selection, new Listener() {
		@Override
		public void handleEvent(Event event)
		{
			text2.setText(text1.getText());
		}		
	});
	
	copy2to3.addListener(SWT.Selection, new Listener() {
		@Override
		public void handleEvent(Event event)
		{
			text3.setText(text2.getText());
		}		
	});
	
	
	
	
	
	
	
	shell.open();
	while (!shell.isDisposed()) {
		if (!display.readAndDispatch())
			display.sleep();
	}
	display.dispose();
}
}