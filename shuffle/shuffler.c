#include<stdio.h>
#include<stdlib.h>

void shuffle(int a[]) {

        time_t t;
        srand((unsigned) time(&t));

        int i;
        for(i = 0; i < 100; i++) {
                int shPos = i + rand() % (100-i);
                int temp = a[i];
                a[i] = a[shPos];
                a[shPos] = temp;
        }
}

int main(void) {

        int a[100];
        int i;
        for(i = 1; i <= 100; i++) {
                a[i-1] = i;
        }

        shuffle(a);

        for(i = 0; i < 100; i++) {
                printf("%d\t",a[i]);
        }

        return 0;

}
