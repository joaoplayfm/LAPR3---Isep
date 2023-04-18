.section .text
.global sens_pluvio
sens_pluvio:
    cmp $0, %dil
    je check
    jmp temp

check:
    cmpb $0, %dl
    js zero
    jmp temp

zero:
    movq $0, %rax
    jmp end

temp:
    cmpb $12, %sil
    jge high
    jmp lower

high:
    cmpb $0, %dl
    js negative
    movb %dl, %al
    movb $3, %cl
    idivb %cl, %al
    addb %al, %dil
    cmpb $0, %dil
    js zero
    movq %rdi, %rax
    jmp end

negative:
    movq $0, %r10
    subb %dl, %r10b
    movq %r10, %rdx
    movb %dl, %al
    movb $3, %cl
    idivb %cl, %al
    subb %al, %dil
    cmpb $0, %dil
    js zero
    movq %rdi, %rax
    jmp end

lower:
    addb %dl, %dil
    cmpb $0, %dil
    js zero
    movq %rdi, %rax
    jmp end

end:
    ret
