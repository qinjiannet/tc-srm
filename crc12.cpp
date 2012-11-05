/**
CRC12
*/
#include <cstring>
#include <stdlib.h>
#include <cstdio>
#include <iostream>
#define CHAR_SIZE 8
#define CRC_SIZE 12
using namespace std;
uint32_t PATTERN = 0x180F; //x12 + x11 + x3 + x2 + x + 1

uint32_t crc12(char* data) {
    int len = strlen(data);
    uint32_t reamainder = 0;
    uint32_t nremainder = 0;
    for (int i = 0; i < len; i++) {
        for (int j = CHAR_SIZE - 1; j >= 0; j--) {
            bool bit = (data[i] & (1 << j)) > 0;
            bool lb = (remainder & (1 << (CRC_SIZE - 1))) > 0;
            int fb = lb ^ bit;
            nremainder = fb;
            for (int k = 1; k < CRC_SIZE; k++) {
                int cb = (remainder & (1 << (k - 1))) >> k - 1;
                if (PATTERN & (1 << k)) {
                    nremainder |= (cb ^ fb) << k;
                } else {
                    nremainder |= cb << k;
                }
            }
            remainder = nremainder;
        }
    }
    return remainder;
}

char* char_to_binary(char ch) {
    return num_to_binary(ch,CHAR_SIZE);
}

char* num_to_binary(int num, int size) {
    char* output = (char*)malloc((size + 1) * sizeof(char));
    if (output == NULL)
        return NULL;
    for (int i = 0; i < size; i++) {
        output[size - i - 1] = (num & 1) + '0';
        num >>= 1;
    }
    output[size] = 0;
    return output;
}

int main () {
    char input[] = "Hello";
    int len = strlen(input);
    int data = crc12(input);
    printf("CRC12 remainder of str \"%s\" is %x\n",input,data);
    printf("The binary string is:\n");
    for (int i = 0; i < len; i++) {
        printf("%s ",char_to_binary(input[i]));
    }
    printf("%s\n",num_to_binary(data, CRC_SIZE));
    return 0;
}
