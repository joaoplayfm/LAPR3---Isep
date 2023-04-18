.section .data

.global state
.global inc

   oldstate:
		 .quad 0
   xorshifted:
         .int 0
   rot:
		 .int 0
   n1:
		.quad 6364136223846793005
 

.section .text

.global pcg32_random_r

pcg32_random_r:

movl $0, %eax
movq oldstate(%rip), %r8
movq state(%rip), %r9
movq inc(%rip), %r10
movl xorshifted(%rip), %r11d
movl rot(%rip), %r12d

inicialize:
movq %r9, %r8   				


movq n1(%rip),%rax
mulq %r8    					

orq $1, %r10 

addq %r10, %rax 				

movq %rax, state(%rip)					

movq $0, %rax

movq %r8, %r14                
movq %r8, %rdx    			
shrq $18, %r8  				
					
xorq %rdx, %r8

shrq $27, %r8 	
			
movq %r8, %r11				
				

shrq $59, %r14				
movl %r14d, %r12d
movb %r12b, %cl             


movl %r11d, %edx
movl %r11d, %ecx
shrl %cl, %edx				

movl $0xFFFFFFFF , %eax
mull %ecx


andl $31, %ecx           
shll %cl, %r11d				

orl %edx, %r11d					
movl %r11d, %eax

ret











