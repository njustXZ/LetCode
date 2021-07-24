//package com.njustxz.Sort;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.jar.JarEntry;

public class SortMethod {
    public static void main(String[] args) {
        int[] arr2 = {2, 1, 2, 2, 2};
        int[] arr1 = new int[500];
        for (int i = 0; i < 500; i++) {
            arr1[i] = (int) ((Math.random()) * 500);
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + "  ");
            if (i % 10 == 9) System.out.println();
        }
        Date dat = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String t1 = simpleDateFormat.format(dat);
        System.out.println("������ǰʱ�䣺" + t1);
//        shellSort(arr2);
        quickSort(arr2,0,arr2.length -1);
        System.out.println("�����");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + "  ");
            if (i % 10 == 9) System.out.println();
        }
        dat = new Date();
        System.out.println("�����ʱ�䣺" + simpleDateFormat.format(dat));
    }

    //ð������
    public static void bubbleSort(int[] arr) {
        int tmp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            if (!flag) {
                break;
            }
            flag = false;
        }
    }

    //ѡ������
    public static void chooseSort(int[] arr) {
        int index = 0;
        int tmp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            tmp = arr[i];
            index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < tmp) {
                    tmp = arr[j];
                    index = j;
                }
            }
            if (index != i) {
                tmp = arr[i];
                arr[i] = arr[index];
                arr[index] = tmp;
            }
        }
    }

    //��������
    public static void insertSort(int[] arr) {
        int s1 = 0;
        int n = arr.length;
        int insertVal, insertIndex;
        for (int i = 1; i < n; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex = insertIndex - 1;
            }
            if (insertIndex != i - 1) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }

    //ϣ������
    public static void shellSort(int[] arr) {
        int gap, n = arr.length;
        gap = n / 2;
        int insertVal, insertIndex;
        while (gap > 0) {
            for (int i = 0; i < gap; i++) {
                for (int j = gap + i; j < n; j = j + gap) {
                    insertIndex = j - gap;
                    insertVal = arr[j];
                    while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                        arr[insertIndex + gap] = arr[insertIndex];
                        insertIndex = insertIndex - gap;
                    }
                    if (insertIndex + gap != j) {
                        arr[insertIndex + gap] = insertVal;
                    }
                }
            }
            gap = gap / 2;
        }
    }

    //��������
    //��Ҫע��ļ��㣺1.
    public static void quickSort(int[] arr, int left, int right) {
        int tmp = 0;
        int l = left;
        int r = right;
        int pivot = arr[(left + right)/2];
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        if (r == l) {
            r--;
            l++;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    //�鲢����
    public static void mergeSort(int [] arr,int left,int right,int[] temp) {
        if(left<right){
            //�ȷֽ�
            int mid = (left+right)/2;
            //����ֽ�
            mergeSort(arr,left,mid,temp);
            //���ҷֽ�
            mergeSort(arr,mid+1,right,temp);
            //�ϲ�
            merge(arr,left,mid,right,temp);
        }
    }

    public static void merge(int [] arr,int left,int mid,int right,int[] temp) {

    }
}
