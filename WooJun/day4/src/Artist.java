
package assignment2;

public class Artist extends Raise implements Fame {
    private String name;
    private int price;
    private int work_count;
    private int fame;
    private boolean own;

    public Artist() {
        this.name = "화가";
        this.price = 300;
        this.work_count = 0;
        this.fame = 0;
        this.own = false;
    }

    //getter

    public String getName() {
        return name;
    }

    public int getWork_count() {
        return work_count;
    }

    public int getFame() {
        return fame;
    }

    public boolean getOwn(){
        return own;
    }


    //setter

    public void setOwn() {
        this.own = true;
    }


    @Override
    public int work(int money) {
        System.out.println(name+"가 일을 합니다.");
        if(work_count % 5 == 0 && work_count != 0){
            System.out.println(name+"가 일한 지 "+work_count+"일이 지나 돈을 받습니다.");
            work_count++;
            fame_up();
            return price*fame;
        }else{
            work_count++;
            return 0;
        }
    }

    @Override
    public int buy_person(int money) {
        if(money >= price){
            setOwn();
            System.out.println(name+"를 구매하였습니다.");
            return price;
        }
        else {
            System.out.println("잔액이 부족합니다. 잔액 : "+money);
            return 0;
        }
    }

    @Override
    public void fame_up(){
        System.out.println(name+"의 인기도가 올랐습니다.");
        fame++;
    }
}
