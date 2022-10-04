import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<item> ITEMS=new ArrayList<>();
        List<item> ITEMS2=new ArrayList<>();
        ITEMS.add(new item("building tools",2000));
        ITEMS.add(new item("building tools",2000));
        ITEMS.add(new item("building tools",5000));
        ITEMS.add(new item("building tools",5000));
        ITEMS.add(new item("building tools",2000));
        ITEMS.add(new item("building tools",1000));
        ITEMS.add(new item("building tools",5000));
        ITEMS.add(new item("building tools",2000));
        ITEMS.add(new item("building tools",1000));
        ITEMS.add(new item("building tools",5000));
        ITEMS.add(new item("building tools",6000));
        ITEMS.add(new item("shelter equipment",5000));
        ITEMS.add(new item("construction equipment",5000));
        ITEMS.add(new item("plants",1000));
        ITEMS.add(new item("steel",8000));
        ITEMS.add(new item("books",1000));
        ITEMS.add(new item("water",5000));
        ITEMS.add(new item("habitat",3000));
        ITEMS.add(new item("colony",5000));
        ITEMS.add(new item("food",5000));
        ITEMS.add(new item("habitat",3000));
        ITEMS.add(new item("colony",5000));
        ITEMS.add(new item("food",3000));
        ITEMS.add(new item("colony",5000));
        ITEMS.add(new item("food",3000));
        ITEMS2.addAll(ITEMS);
        System.out.println("Total numbers of items are : "+ITEMS2.size());
        while(ITEMS.size()!=0) {
            //the u1 rocket price is 100;so amount=100;
            //crash probability for U1 is 5%;
            //maxload for u1=18000 kg;
            int amont=100;
            ITEMS = important.simulations(ITEMS,amont,u1.Maxload,5);

        }
        System.out.println("So the total amount for U1 is  : "+u1.cost+" dolors");
        System.out.println("-----------------------------------------------------------------");
        u1.cost=0;
        while(ITEMS2.size()!=0) {
            int amont=120;
            ITEMS2 = important.simulations(ITEMS2,amont,u2.Maxload,8);
            //u2.cost+=120;
       }
        System.out.println("So the total amount for U2 is  : "+u1.cost+" dolors");
        System.out.println("-----------------------------------------------------------------");
    }
}
class important
{
    public  static List<item> simulations(List<item> ITEMS,int amount,int maximum,int crashprob)
    {
        //U1LOADLIST list is created for storing loaded items and its kg;
        //result list created for also storing loaded items and its kg,but it does not allow repeated names items;
        List<item> result=new ArrayList<>();
        int pickload=0;
        List<item> U1LOADLIST=new ArrayList<>();
        boolean a=true;
        int count=0;
        //this while loop is used for load the item in the rocket below its maximum capacity;
        while(a) {
            for (item i : ITEMS) {
                if (pickload + (i.value) < maximum) {
                    pickload += i.value;
                    U1LOADLIST.add(new item(i.name, i.value));
                    count++;
                } else break;

            }
            a = false;

        }
        //this for loop is used for whether the items is already loaded or not;
        for(item i:U1LOADLIST) {
            int c=0;
            for(item j:result)
            {
                if(i.name.equals(j.name))
                {
                    j.value+=i.value;
                    c++;
                }
            }
            if(c==0)
                result.add(new item(i.name,i.value));
        }
        System.out.println("PICKUP LOAD : "+pickload);
        int whilelaunching=crashprob*pickload/maximum;
        //this if-else is used for whether the rocket crash or not
        if(whilelaunching<RANDOM.Random())
        {
            System.out.println("successfully launched");
            u1.cost+=amount;
            System.out.println("cost : "+u1.cost);
            for(item i:result)
                System.out.println(i.name+":"+i.value);

        }
        else {
            System.out.println("failure");
            u1.cost+=amount;
            System.out.println("Cost : "+u1.cost);
            RANDOM.check(whilelaunching,result,amount);

        }
        //this for loop is used for remove the loaded items from the ITEMS list;
        for(int i=0;i<count;i++)
            ITEMS.remove(0);
        System.out.println("Remaining Items : "+ITEMS.size());
        System.out.println("---------------------------");
        return ITEMS;
    }
}
class item
{
    String name;
    int value;
    item(String name,int value)
    {
        this.name=name;
        this.value=value;
    }
}
class u1
{
    static int cost=0;//100;
    static int Maxload=18000;
}
class u2
{
    static int cost=120;
    static int Maxload=29000;
}
class RANDOM
{
    public  static int Random()
    {
        double random=Math.random();
        random*=10;
        return (int) random;
    }
    public  static void check(int whilelaunching, List<item> result,int amount)
    {
        if(whilelaunching<RANDOM.Random())
        {
            System.out.println("--------");
            System.out.println("successfully launched");
            u1.cost+=amount;
            System.out.println("cost : "+u1.cost);
            for(item i:result)
                System.out.println(i.name+":"+i.value);

        }
        else {
            System.out.println("failure");
            u1.cost+=amount;
            System.out.println("Cost : "+u1.cost);
            check(whilelaunching,result,amount);
        }
    }
}