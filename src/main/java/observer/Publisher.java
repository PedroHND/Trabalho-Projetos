
package observer;

import java.util.ArrayList;


public class Publisher {
    private ArrayList<Subscriber> subscribers = new ArrayList<Subscriber>();
    
    public void addSubscriber(Subscriber sub){
        subscribers.add(sub);
    }
    
    public void removeSubscriber(Subscriber sub){
        subscribers.remove(sub);
    }
    
    public void notifySubscribers(){
        for(Subscriber sub : subscribers){
            sub.update();
        }
    }
}
