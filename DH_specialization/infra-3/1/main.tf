provider "aws" {
  region = "sa-east-1"
}

resource "aws_instance" "barretto_ec2" {
    count = 2
  ami           = "ami-04b3c23ec8efcc2d6"
  instance_type = "t2.micro"
  key_name      = "barretto.terraform-aws"
  tags = {
    "Name" = "barretto-ec2_${count.index}"
  }
}

resource "aws_key_pair" "chave_terraform_aws" {
  key_name   = "barretto.terraform-aws"
  public_key = file("terraform-aws.pub")
}
