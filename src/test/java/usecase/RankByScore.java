package usecase;

import org.junit.Test;

import java.util.*;

/**
 * 维护一个排行榜
 * 1、可以通过id查询到score
 * 2、可以正向遍历得到按score倒序的结果列表
 * 3、支持实时更新分数
 *
 * @author ShaneTang
 * @create 2021-04-10 21:19
 */
public class RankByScore {


    static interface LeaderBoard {
        void put(int id, int score);

        int get(int id);

        void show();
    }

    /**
     * arrayList作为排行榜存entry，能同步修改，不过每次都得排序输出
     */
    @Test
    public void hashMapImpl() {

        class LeaderBoardImpl implements LeaderBoard {
            ArrayList<Map.Entry<Integer, Integer>> arrayList = new ArrayList<>();

            HashMap<Integer, Integer> hashMap = new HashMap<>();

            @Override
            public void put(int id, int score) {
                hashMap.put(id, score);
            }

            @Override
            public int get(int id) {
                return hashMap.get(id);
            }

            @Override
            public void show() {
                arrayList = new ArrayList<>();
                arrayList.addAll(hashMap.entrySet());
                arrayList.sort((o1, o2) -> o2.getValue() - o1.getValue());
//                arrayList.sort((t1, t2) -> {
//                    int score = t2.getScore() - t1.getScore();
//                    if (score != 0) {
//                        return score;
//                    }
//                    return t1.getId() - t2.getId();
//                });
                System.out.println(arrayList);
            }
        }
        LeaderBoard leaderBoard = new LeaderBoardImpl();
        leaderBoard.put(1, 4);
        leaderBoard.put(2, 5);
        leaderBoard.put(3, 3);
        leaderBoard.put(4, 6);
        leaderBoard.put(5, 2);
        leaderBoard.put(6, 3);
        leaderBoard.put(7, 1);

        System.out.println("leaderBoard.get(3) = " + leaderBoard.get(3));
        leaderBoard.show();

        leaderBoard.put(3, 9);
        System.out.println("leaderBoard.get(3) = " + leaderBoard.get(3));
        leaderBoard.show();
    }

    /**
     * 无法 get update
     */
    @Test
    public void pqImpl() {
        class LeaderBoardImpl implements LeaderBoard {

            PriorityQueue<Team> pq = new PriorityQueue<>((t1, t2) -> t2.getScore() - t1.getScore());

            @Override
            public void put(int id, int score) {
                pq.add(new Team(id, score));
            }

            @Override
            public int get(int id) {
                return 0;
            }

            @Override
            public void show() {
                System.out.println("pq = " + pq);
            }

        }

        LeaderBoard leaderBoard = new LeaderBoardImpl();
        leaderBoard.put(1, 4);
        leaderBoard.put(2, 5);
        leaderBoard.put(3, 3);
        leaderBoard.put(4, 6);
        leaderBoard.put(5, 2);
        leaderBoard.put(6, 3);
        leaderBoard.put(7, 1);

        leaderBoard.show();

        System.out.println("leaderBoard.get(3) = " + leaderBoard.get(3));

        leaderBoard.put(3, 9);

        leaderBoard.show();
    }

    /**
     * 　无法 get update
     */
    @Test
    public void treeMapImpl() {

        class LeaderBoardImpl implements LeaderBoard {

            TreeMap<Team, Integer> treeMap = new TreeMap<>((o1, o2) -> {
                int id = o1.getId() - o2.getId();
                if (id != 0) {
                    return id;
                }
                return o2.getScore() - o1.getScore();
            });

            @Override
            public void put(int id, int score) {
                Team team = new Team(id, score);
                treeMap.put(team, score);
            }

            @Override
            public int get(int id) {
//                return treeMap.get(new Team(id));
                return -1;
            }


            @Override
            public void show() {
                System.out.println("treeMap.keySet() = " + treeMap.keySet());
            }
        }

        LeaderBoard leaderBoard = new LeaderBoardImpl();
        leaderBoard.put(1, 4);
        leaderBoard.put(2, 5);
        leaderBoard.put(3, 3);
        leaderBoard.put(4, 6);
        leaderBoard.put(5, 2);
        leaderBoard.put(6, 3);
        leaderBoard.put(7, 1);

        leaderBoard.show();

        System.out.println("leaderBoard.get(3) = " + leaderBoard.get(3));

        leaderBoard.put(3, 9);

        leaderBoard.show();

    }

    /**
     * 无法 get update
     */
    @Test
    public void treeSetImpl() {


        TreeSet<Team> treeSet = new TreeSet<>((o1, o2) -> {
            int num1 = o2.score - o1.score;
            if (num1 != 0) {
                return num1;
            }
            // 这个比较器必须完善，如果只看分数，那同分的就算同一个对象了，而实际应该区分id
            return o1.id - o2.id;
        });
        /*TreeSet treeSet = new TreeSet<>((Comparator<Team>) (o1, o2) -> o1.score - o2.score);*/

        treeSet.add(new Team(1, 4));
        treeSet.add(new Team(2, 5));
        treeSet.add(new Team(3, 3));
        treeSet.add(new Team(4, 6));
        treeSet.add(new Team(5, 2));
        treeSet.add(new Team(6, 3));

        for (Team team : treeSet) {
            System.out.println(team);
        }


    }


    static class Team {
        int id;
        int score;

        public Team(int id) {
            this.id = id;
        }

        public Team(int id, int score) {
            this.id = id;
            this.score = score;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Team team = (Team) o;
            return id == team.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return "Team{" +
                    "id=" + id +
                    ", score=" + score +
                    '}';
        }
    }


}
