def stackCreation(){
	pipeline {
		agent any
		environment {
			AWS_DEFAULT_REGION = 'us-east-1' 
		}
		stages {
			stage('Create CloudFormation Stack') {
				steps {
					script {
						sh cd /home/ec2-user
						sh 'aws cloudformation create-stack --stack-name ${STACK_NAME} --template-body file:///home/ec2-user/CF-JK-Test.yaml'
					}
				}
			}			
		}
	}
}

def wait(){
	pipeline{
		agent any 
		environment {
			AWS_DEFAULT_REGION = 'us-east-1' 
		}
		stages{
			stage('wait for 2 hours'){
				steps{
					script{
						sleep(time: 2, unit: 'HOURS')
					}
				}
			}	
		}
	}
}	

def Deletion(){
	pipeline{
		agent any
		environment{
			AWS_DEFAULT_REGION = 'us-east-1' 
		}
		stages{
			stage('Stack Deletion'){
				steps{
					script{
						sh 'aws cloudformation delete-stack --stack-name ${STACK_NAME}'
					}
				}
			}
		}
	}
}	
	
	

# @Library('my-shared-library') _
# common()

	
	
	
	
	
	