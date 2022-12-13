#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
struct order {
    char namePed[200];
    char CPF[200];
    char numPed[200];
    char qtdPed[200];
    char valueped[200];
    int cod;
}logP[200];

struct registry {
    char CPF[200];
    char phone[200];
    char name[200];
    char address[200];
    char date[200];
    int empty,cod;
    struct order clientPed;
}log[200];

int verify_pos(void);
int verify_cod( int cod );
int opt;
void registryP(int cod,int pos);
void list();
void registryOrder();
void checkCod (void);
void removeClient (void);

int main(void) {
    int i,Option,clientOption,position,return_;
    int codaux;
    do {
        printf("1 - Cadastrar cliente\n");
        printf("2 - Consultar cliente\n");
        printf("3 - Alterar cliente\n");
        printf("4 - Excluir cliente\n");
        printf("5 - Cadastrar pedido\n");
        printf("6 - Alterar pedido\n");
        printf("7 - Excluir pedido\n");
        printf("8 - Sair\n");
        printf(" Selecione uma opcao por favor: ");
        scanf("%d", &Option);
        getchar();
        if (Option == 1) {
            printf("Voce selecionou a opcao 1 - Cadastrar cliente\n");
            position=verify_pos();

                if (position != -1) {
                    printf("\nEntre com um codigo de 1 a 200 para seu cadastro: \n");
                    scanf("%d",&codaux);fflush(stdin);
                    return_ = verify_cod(codaux);
                    if (return_ == 1)
                        registryP(codaux, position);
                    else {
                        printf("\nCodigo ja existente ou invalido. Tente novamente.\n");
                        getchar();
                        main();
                    }
                }
                else
                    printf("\nNao e possivel realizar mais cadastros!\n");
                break;
        }
        else if (Option == 2) {
            
            do{
            printf("Voce selecionou a opcao 2 - Consultar cliente\n\n");
            printf("1 - Pesquisar cliente por codigo\n");
            printf("2 - Listar todos os clientes\n");
            printf("3 - Voltar ao menu principal\n");
            printf("Selecione uma opcao por favor: ");
            scanf("%d", &clientOption);
            getchar();
                 if(clientOption == 1) {
                    checkCod();
                }
                else if(clientOption == 2) {
                    list();
                }
                else if(clientOption == 3) {
                    printf("Voce selecionou voltar ao menu principal, pressione ENTER para continuar");
                    getchar();
                    
                }
                else
                    printf("Opcao Invalida\n\n");
    } while(clientOption =!3 || clientOption > 3 || clientOption < 0 || clientOption == 0);
        } else if (Option == 3) {
            printf("Voce selecionou a opcao 3 - Alterar cliente\n");
        } else if (Option == 4) {
            printf("Voce selecionou a opcao 4 - Excluir cliente\n");
            removeClient();
        } else if (Option == 5) {
            printf("Voce selecionou a opcao 5 - Cadastrar pedido\n");
            registryOrder();
        } else if (Option == 6) {
            printf("Voce selecionou a opcao 6 - Alterar pedido\n");
        } else if (Option == 7) {
            printf("Voce selecionou a opcao 7 - Excluir pedido\n");
        } else if (Option == 8) {
            printf("Voce selecionou a opcao 8 - Sair\n");
        } else {
            printf("Opcao invalida, tente novamente.");
            getchar();
            
        } 
    } while (Option != 8 || Option < 8);
}

void list() {
    int i;
    for (i = 0; i < 200; i++){
        if(log[i].cod!=NULL){
            printf("\nCodigo: %d \nNome: %s\nCPF: %s\nEndereco: %s\nTelefone: %s\n\n", log[i].cod,log[i].name,log[i].CPF,log[i].address,log[i].phone);
    }
}
printf("Pressione enter para volta ao menu principal");
getchar();


} 

void registryP(int cod, int pos) {
    int i;
    do{
    pos = verify_pos();
    log[pos].cod = cod;
        printf("\nDigite seu nome: ");
        gets(log[pos].name);
        printf("\nDigite seu CPF: ");
        gets(log[pos].CPF);
        printf("\nDigite seu Endereco: ");
        gets(log[pos].address);
        printf("\nDigite seu Telefone: ");
        gets(log[pos].phone);
        log[pos].empty = 1;
        printf("\nDigite enter para efetuar novo cadastro ou qualquer outra tecla para volar ao menu principal");
        scanf("%d", &opt);
        opt ==1;
        getchar();
    } while(opt==1);
    
    main();
} 

int verify_pos( void ) {
    int cont = 0;
    while (cont <= 200) {
        if ( log[cont].empty == 0 )
            return(cont);
        cont++;
    }
    return(-1);
} 

int verify_cod(int cod) {
    int cont = 0;
    while (cont <= 200) {
        if (log[cont].cod == cod)
            return(0);
        cont++;
    }
    return(1);
} 

void registryOrder() {     
    int i;
    int Option;
    int OrderOption;
    char nameCad[200];
    printf("\nDigite seu nome como esta no cadastro: ");
    gets(nameCad);
    for(i=0;i<200;i++) {
            if(strcmp(log[i].name, nameCad)==0) {
                do {
                    printf("\nEscolha o seu pedido: "); //PEDIDOS MERAMENTE ILUSTRATIVOS, COLOQUEI SÓ PARA VER SE CONSEGUIA ANEXAR A 1 CADATRO MAS NÃO CONSEGUI.
                    printf("\n1- McCheddar");
                    printf("\n2- McTasty");
                    printf("\n3- McNífico\n:");
                    scanf("%d", &OrderOption);
                    if(OrderOption == 1)    {
                        strcpy(log[i].clientPed.namePed, "McCheddar");
                        printf("\nVoce escolheu %s, seu pedido foi adicionado ao seu cadastro.",log[i].clientPed.namePed);
                        printf("\nPressione 1 para continuar pedindo ou 2 para volar ao menu principal: ");
                        scanf("%d", &Option);
                        i++;
                    }
                    else if(OrderOption == 2) {
                        strcpy(log[i].clientPed.namePed, "McTasty");
                        printf("\nVoce escolheu %s, seu pedido foi adicionado ao seu cadastro.", log[i].clientPed.namePed);
                        printf("\nPressione 1 para continuar pedindo ou 2 para volar ao menu principal: ");
                        scanf("%d", &Option);
                        i++;
                    } else if(OrderOption == 3) {
                        strcpy(log[i].clientPed.namePed, "McNífico");
                        printf("\nVoce escolheu %s, seu pedido foi adicionado ao seu cadastro.", log[i].clientPed.namePed);
                        printf("\nPressione 1 para continuar pedindo ou 2 para volar ao menu principal: ");
                        scanf("%d", &Option);
                        i++;
                    }
                } while(Option == 1);
            }
    }
} 
void checkCod (void) {
    int cont = 0, cod;
    printf("\nEntre com o codigo\n");
    scanf("%d",&cod);
    fflush(stdin);   

    while ( cont <= 200 ) {
        if (log[cont].cod==cod) {
            if (log[cont].empty==1) {
                printf("\nCodigo: %d \nNome: %s\nCPF: %s\nEndereco: %s\nTelefone: %s\n\n", log[cont].cod,log[cont].name,log[cont].CPF,log[cont].address,log[cont].phone);
                break;
            }
        }
        cont++;
        if ( cont > 200 ){
            printf("\nCodigo nao encontrado, pressione enter para volar ao menu principal\n");
            getchar();  
        }
    }
}

void removeClient(void) {
    int cod, cont = 0;
    char resp;
    printf("\nEntre com o codigo do registro que deseja excluir: \n");
    scanf("%d", &cod);
    while (cont <= 200) {
        if ( log[cont].cod == cod ) {
            if (log[cont].empty == 1) {
                printf("\nCodigo: %d \nNome: %s\nCPF: %s\nEndereco: %s\nTelefone: %s\n\n", log[cont].cod,log[cont].name,log[cont].CPF,log[cont].address,log[cont].phone);
                getchar();
                printf("\nDeseja realmente exlucir? s/n: ");
                scanf("%s",&resp);

                if ((resp == 'S') || (resp == 's')) {
                    log[cont].empty = 0;
                    log[cont].cod = NULL;
                    printf("\nExclusao feita com sucesso\n");
                    break;
                } else {
                    if ( ( resp == 'N' ) || ( resp == 'n' ) ) {
                        printf("Exclusao cancelada!\n");
                        break;
                    }
                }
            }
        }
        cont++;
        if (cont > 200)
            printf("\nCodigo nao encontrado\n");
    }
}
