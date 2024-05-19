package Subject02;

public class Wizard extends Raise implements Fame{
    int work_count;
    int fame;


    @Override
    public int buy_person(int money) {
        if(money >= 10) {
            System.out.println("마법사를 구매하셨습니다.");
            return money - 2000;
        }

        else {
            System.out.println("돈이 부족합니다.");
            return -1;
        }
    }

    @Override
    public int work(int money) {
        work_count++;

        if(this.work_count % 5 == 0) {
            fame_up();
            System.out.println("마법사가 일을 합니다.");
            return money + 2000 * this.fame;
        }
        else return money;
    }

    @Override
    public void fame_up() {
        this.fame++;
    }

}
