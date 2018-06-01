package algorithm;

import java.util.Arrays;

public class sumOfThreeElement {
    void find3Numbers(int A[], int n, int X)
    {
        int mid, left, right;
        Arrays.sort(A);

        for (int i = 0; i < n - 3; i++)
        {
            left = i;
            for (int j = n-1; j > i+1 ; j--)
            {
                right = j;
                mid = (left + right)/2;

                while (mid>i && mid<j)
                {
                    if (A[i] + A[j] + A[mid] == X)
                    {
                        System.out.println(A[i]+" "+A[mid]+" "+A[j]);
                        break;
                    }
                    else if (A[i] + A[j] + A[mid] < X)
                    {
                        left = mid;
                        mid = (mid + right)/2  + 1;
                    }
                    else {
                        right = mid;
                        mid = (left + mid) / 2;
                    }
                }
            }
        }
    }
/*
    public static void main(String[] args)
    {
        sumOfThreeElement find = new sumOfThreeElement();
        int A[] = {1, 4, 5, -6, 1, 7};
        int n = A.length;
        int X = 6;
        find.find3Numbers(A, n, X);
    }*/
}
