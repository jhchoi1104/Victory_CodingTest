import sys
n = int(sys.stdin.readline())

stack = []
for i in range(n):
	command = sys.stdin.readline().split()
	
	# ✅ push X: 정수 X를 스택에 넣는 연산이다.
	if command[0] == 'push':
		stack.append(command[1])
	# 연산: 스택에 정수를 추가합니다.
	# 시간 복잡도: 𝑂(1)
	
	
	# ✅ pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.	
	elif command[0] == 'pop':
		if len(stack) == 0:
			print(-1)
		else:
			print(stack.pop())
	# 연산: 스택에서 가장 위에 있는 정수를 제거하고 출력합니다.
	# 시간 복잡도: 𝑂(1)
	
	# ✅ size: 스택에 들어있는 정수의 개수를 출력한다.		
	elif command[0] == 'size':
		print(len(stack))
	# 연산: 스택에 들어있는 정수의 개수를 출력합니다.
	# 시간 복잡도: 𝑂(1)
		
	# ✅ empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
	elif command[0] == 'empty':
		if len(stack) == 0:
			print(1)
		else:
			print(0)
	# 연산: 스택이 비어있는지 확인하고, 결과를 출력합니다.
	# 시간 복잡도: 𝑂(1)
	
	# ✅ top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	elif command[0] == 'top':
		if len(stack) > 0:
			print(stack[-1])
		else:
			print(-1)
	# 연산: 스택의 가장 위에 있는 정수를 출력합니다.
	# 시간 복잡도: 𝑂(1)
	
	# 전체적으로 각 명령은 모두 상수 시간 복잡도를 가지므로, 입력된 명령의 수가 n일 때, 프로그램의 전체 시간 복잡도는 O(n)입니다.
	# 따라서, 전체 코드의 시간 복잡도는 O(n)