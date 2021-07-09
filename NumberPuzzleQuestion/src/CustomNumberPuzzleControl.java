import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		System.out.println(emptyCellId);
		System.out.println(buttonClicked.getLabel());
		Button[] buttons = game.getButtons();
		
		//Your logic here
		
		
		for (int i=0;i<16;i++) {
			if (buttons[i].getLabel().equals(buttonClicked.getLabel())) {
				if(i-1==emptyCellId || i+1 == emptyCellId || i-4==emptyCellId || i+4 == emptyCellId) {
					swapButton(buttons[emptyCellId],buttonClicked);
					emptyCellId = i;
					break;
				}
				
			}
		}
		
		return emptyCellId;

	}
	public boolean search(int[] arr,int ele) {
		for(int i=0;i<15;i++) {
			if(arr[i]==ele) {
				return false;
			}
		}
		return true;
		
	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		for(int i=0;i<15;i++) {
			arr[i] = 0;
		}
		//Your logic here
		for(int i=0;i<15;i++) {
			int a = (getRandomNumber()%15)+1;
			while(search(arr,a)!=true) {
				a = (getRandomNumber()%15)+1;
			}
			arr[i] = a;
		}
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int [] arr = getIntegerArrayOfButtonIds(buttons);
		for(int i=1;i<=15;i++) {
			if(i!=arr[i]) {
				return false;
			}
		}

		return winner;
	}
}