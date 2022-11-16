package timeattack;

public class Main4 { //로그인 성공?
    public static String solution(String[] id_pw, String[][] db) {
        String answer = "fail";

        for(int i = 0; i < db.length; i++) {
            if(id_pw[0].equals(db[i][0])) {
                if (id_pw[1].equals(db[i][1]))
                    answer = "login";
                else answer = "wrong pw";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] id_pw = {"rabbit04", "98761"};
        String[][] db = {{"jaja11", "98761"}, {"krong0313", "29440"}, {"rabbit00", "111333"}};

        System.out.println(solution(id_pw, db));
    }
}
