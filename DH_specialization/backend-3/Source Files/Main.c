#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>

struct vehicle {
    char    *brand[10];
    int     model_year;
    char    *plate[8];
};

struct vehicle vehicles[];

void add_brand(char brand[50], int location) {
    strncpy(vehicles[location].brand, brand, 50);
}

void add_plate(char plate[8], int location) {
    strncpy(vehicles[location].plate, plate, 8);
}

void add_model_year(int model_year, int location) {
    vehicles[location].model_year = model_year;
}

void add_vehicle(char brand[50], int model_year, char plate[8], int location) {
    add_brand(brand, location);
    add_model_year(model_year, location);
    add_plate(plate, location);
}

void get_all_vehicles() {
    for(int i = 0; i < 10; i++) {
        int vehicle_number = i + 1;
        printf("Vehicle %d \n", vehicle_number);
        printf("Brand: %s \n", vehicles[i].brand);
        printf("Year Model: %d \n", vehicles[i].model_year);
        printf("Plate: %s \n\n", vehicles[i].plate);
    }
}

void get_all_vehicles_by_model_year(int model_year) {
    int vehicle_number = 0;
    printf("Vehicle filtered by year model\n");
    for(int i = 0; i < 10; i++) {
        if(vehicles[i].model_year == model_year) {
            printf("Vehicle %d \n", ++vehicle_number);
            printf("Brand: %s \n", vehicles[i].brand);
            printf("Year Model: %d \n", vehicles[i].model_year);
            printf("Plate: %s \n\n", vehicles[i].plate);
        }
    }
}

void get_all_vehicles_above_model_year(int model_year) {
    int vehicle_number = 0;
    printf("Vehicle filtered above year model\n");
    for(int i = 0; i < 10; i++) {
        if(vehicles[i].model_year >= model_year) {
            printf("Vehicle %d \n", ++vehicle_number);
            printf("Brand: %s \n", vehicles[i].brand);
            printf("Year Model: %d \n", vehicles[i].model_year);
            printf("Plate: %s \n\n", vehicles[i].plate);
        }
    }
}

void get_all_vehicles_by_model(char brand[50]) {
    int vehicle_number = 0;
    printf("Vehicle filtered above brand\n");
    for(int i = 0; i < 10; i++) {
        if(strcmp(vehicles[i].brand, brand) == 0) {
            printf("Vehicle %d \n", ++vehicle_number);
            printf("Brand: %s \n", vehicles[i].brand);
            printf("Year Model: %d \n", vehicles[i].model_year);
            printf("Plate: %s \n\n", vehicles[i].plate);
        }
    }
}

bool menu_actions(int awnser) {
    char brand[50];
    char plate[8];
    int model_year, location;
    switch (awnser) {
        case 0: 
            printf("Exiting program...");
            return false;
        case 1: 
            get_all_vehicles();
            return true;
        case 2:
            printf("Which year do you want?");
            scanf("%d", &model_year);
            get_all_vehicles_by_model_year(model_year);
            return true;
        case 3:
            printf("Which year do you want?");
            scanf("%d", &model_year);
            get_all_vehicles_above_model_year(model_year);
            return true;
        case 4:
            printf("Which vehicle you want to replace? - ");
            scanf("%d", &location);
            location--;
            printf("What brand is? - ");
            scanf("%s", &brand);
            add_brand(brand, location);
            fflush(stdin);
            printf("What model year is? - ");
            scanf("%d", &model_year);
            add_model_year(model_year, location);
            printf("What plate is? - ");
            scanf("%s", &plate);
            add_plate(plate, location);
            return true;
        default:
            printf("Value not identify. Try again.\n");
            return true;
    }
}

int menu() {
    bool is_active_system = true;
    while (is_active_system) {
        int user_awnser;
        printf("_________________ MENU ________________\n");
        printf("1 - List all vehicles;\n");
        printf("2 - List by model year;\n");
        printf("3 - List above model year;\n");
        printf("4 - Add a vehicle;\n");
        printf("0 - Exit\n");
        scanf("%d", &user_awnser);
        is_active_system = menu_actions(user_awnser);
        
    }
}

int main() {
    add_vehicle("Toyota", 2014, "OVS-7178", 0);
    add_vehicle("Tesla", 2022, "KPT-1230", 1);
    add_vehicle("Honda", 2018, "KVA-9823", 2);
    add_vehicle("Ford", 2017, "ONE-8710", 3);
    add_vehicle("Jeep", 2021, "UWN-1028", 4);
    add_vehicle("Suzuki", 2011, "KVT-7723", 5);
    add_vehicle("Fiat", 2009, "NNQ-3478", 6);
    add_vehicle("Renault", 2003, "UJH-2346", 7);
    add_vehicle("Mitsubish", 2003, "ERT-6140", 8);
    add_vehicle("Nissan", 2015, "VVA-9283", 9);
    menu();
    return 0;
}