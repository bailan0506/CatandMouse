
public class Cat {
    private Position myPosition;
    // Constructors.
    public Cat ( ) {
	myPosition = new Position ( );
    }
    
    public Cat (Position p) {
	myPosition = p;
    }
    
    // An access function.
    public Position getPosition ( ) {
	return myPosition;
    }
    public void setPosition (Position p ) {
    	myPosition.setMyRadius(p.getMyRadius());
    	myPosition.setMyAngle(p.getMyAngle());
       }
    // Move the cat around the statue:
    //	one meter toward the statue if the cat sees the mouse (or up to the statue
    //		if the cat is closer to the statue than one meter away), or 
    //	1.25 meters counterclockwise around the statue if the cat doesn't see the mouse.
    // Return true if the cat eats the mouse during the move, false otherwise.
    public boolean move (Position mousePosition) {
	// You fill this in.
    	Position oldPosition=new Position(myPosition);
    	double oldCatR=oldPosition.getMyRadius();
    	double oldCatAngle=oldPosition.getMyAngle();
    	double mouseR=mousePosition.getMyRadius();
    	double mouseAngle=mousePosition.getMyAngle();
    	boolean isSeen= (oldCatR * Math.cos(oldCatAngle-mouseAngle)>=100);
    	if(isSeen)
    		if (oldCatR>=200)
    			myPosition.update(-100, 0);
    		else
    			myPosition.update(100-oldCatR,0);
    	else
    		myPosition.update(0.0,1.25);
       	double newCatR=myPosition.getMyRadius();
    	double newCatAngle=myPosition.getMyAngle();
   // 	mousePosition.update(0, 1);
   // 	mouseR=mousePosition.GetRadius();
   // 	mouseAngle=mousePosition.GetAngle();
    	boolean Eaten=(newCatR==100 && Math.cos(mouseAngle-oldCatAngle)>Math.cos(newCatAngle-oldCatAngle)&& Math.cos(newCatAngle-mouseAngle)>Math.cos(newCatAngle-oldCatAngle));
    	return Eaten;
    }
 
}
