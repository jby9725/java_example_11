package com.koreait;

import java.util.*;

public class App {

    Scanner in = new Scanner(System.in);

    public void run() {
        String cmd = "";

        int lastId = 0;
        Map<Integer, String> list = new HashMap<>();

        while (true) {
            System.out.print("명령) ");
            cmd = in.nextLine();

            if (cmd.equals("exit"))
                break;

            else if (cmd.equals("add")) {
                System.out.print("할일 : ");
                String todo = in.nextLine();
                lastId++;
                list.put(lastId, todo);
                System.out.printf("%d번 할일이 생성되었습니다.\n", lastId);

            } else if (cmd.equals("list")) {
                System.out.println("번호 / 내용");

                // 키 값을 ArrayList에 담아 정렬
                ArrayList<Integer> keys = new ArrayList<>(list.keySet());
                Collections.sort(keys);

                // 정렬된 키 순서대로 값 출력
                for (Integer key : keys) {
                    System.out.printf("%d / %s\n", key, list.get(key));
                }

            } else if (cmd.equals("del")) {
                System.out.print("삭제할 할일의 번호 : ");
                int id = Integer.parseInt(in.nextLine());
                list.remove(id);

            } else if (cmd.equals("modify")) {
                System.out.print("수정할 할일의 번호 : ");
                int id = Integer.parseInt(in.nextLine());
                System.out.println("기존 할 일 : " + list.get(id));
                System.out.print("새 할 일 : ");
                String todo = in.nextLine();
                list.put(id, todo);
                System.out.printf("%d번 할 일이 수정되었습니다.\n", id);

            }
        }

    }
}
