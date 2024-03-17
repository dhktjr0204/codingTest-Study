package Solution.March_2nd.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* 1920번 수 찾기 실버 4
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
 */
public class beakjoon_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] nNums = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();

        int M = Integer.parseInt(br.readLine());

        long[] mNums = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        boolean exist = false;
        int mid = (nNums.length / 2);

        for (int i = 0; i < mNums.length; i++) {
            if (mNums[i] < nNums[mid]) {
                for (int j = 0; j < mid; j++) {
                    if (mNums[i] == nNums[j]) {
                        exist = true;
                        break;
                    }
                }
            } else {
                for (int j = mid; j < nNums.length; j++) {
                    if (mNums[i] == nNums[j]) {
                        exist = true;
                        break;
                    }
                }
            }
            System.out.println(exist ? 1 : 0);
            exist = false;
        }
    }
}