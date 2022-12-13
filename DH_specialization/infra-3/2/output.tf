output "instance_ec2" {
  value = aws_instance.barretto_ec2.*.public_ip
}