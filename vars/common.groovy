def wait(){
	pipeline{
		agent {label ''} 
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

	
	
	
	
	
	