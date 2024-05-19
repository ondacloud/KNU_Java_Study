package Subject02;

public class Artist extends Raise implements Fame {
    int work_count;
    int fame;


    @Override
    public int buy_person(int money) {
        if(money >= 300) {
            System.out.println("아티스트를 구매하셨습니다.");
            return money - 300;
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
            System.out.println("아티스트가 일을 합니다.");
            return money + 300 * this.fame;
        }
        else return money;
    }

    @Override
    public void fame_up() {
        this.fame++;
    }

}
