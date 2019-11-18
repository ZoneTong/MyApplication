//
// Created by 周童 on 2019-11-16.
//

//#include <stdio.h>
//#include <stdlib.h>
//#include <yunxingningmeng.h>
//
//int main(int argc, char **argv){
//    (printhello());
//    return 0;
//}

#include <stdio.h>
#include <string.h>
#include <openssl/md5.h>

void openssl_md5(const char *data, int size, char *rs){
    unsigned char buf[16];

    memset(buf,0,16);

    MD5_CTX c;
    MD5_Init(&c);
    MD5_Update(&c,data,size);
    MD5_Final(buf,&c);

    char tmp[3];
    strcpy(rs,"");
    int i;
    for (i = 0; i < 16; i++){
        sprintf(tmp,"%02x",buf[i]);
        strcat(rs,tmp);
    }
}

int main(int argc, char **argv){
    if (argc != 2){
        printf("Wrong argument.\n");
        return 1;
    }
    char md5str[33];
    openssl_md5(argv[1],strlen(argv[1]),md5str);
    printf("zht ro 23  %s\n",md5str);
    return 0;
}