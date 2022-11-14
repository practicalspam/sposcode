package ex4;

import java.util.Scanner;
import java.util.ArrayList;

public class LRU_ganesh{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Number of Page:");
        int n = sc.nextInt();
        System.out.print("\nEnter the Number of Frames:");
        int capacity = sc.nextInt();
        int arr[] = new int[n];

        System.out.print("\nEnter all the pages:");
        for(int i=0; i<n ; i++)
        {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> s = new ArrayList<Integer>(capacity);
        int count = 0;
        int page_faults = 0;


        for (int i : arr) {

            if (!s.contains(i))
            {
                if (s.size() == capacity)
                {
                    s.remove(0);
                    s.add(capacity - 1, i);
                }
                else
                {
                    s.add(count, i);
                }

                page_faults++;
                count++;

            }
            else
            {
                s.remove((Object) i);
                s.add(s.size(), i);
            }
        }

        System.out.println("\nPage Hits:"+(n-page_faults));
        System.out.println("Page Faults:"+page_faults);
    }
}