.section .text
.global sens_temp
sens_temp:
    addq %rsi, %rdi
    movq %rdi, %rax
    ret