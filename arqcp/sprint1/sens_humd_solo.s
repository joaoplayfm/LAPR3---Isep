.section .text
.global sens_humd_solo
sens_humd_solo:
    movq %rsi, %r8
    movq %rdi, %rcx
    cmpq $0, %r8
    jg rain
    je no_rain

rain:
    addb %dl, %cl
    cmpb $100, %cl
    jg percent
    cmpb $0, %cl
    js zero
    movq %rcx, %rax
    jmp end

no_rain:
    cmpb $0, %dl
    js negative
    movb %dl, %al
    movb $3, %r9b
    idivb %r9b, %al
    addb %al, %cl
    cmpb $100, %cl
    jg percent
    cmpb $0, %cl
    js zero
    movq %rcx, %rax
    jmp end

negative:
    movq $0, %r10
    subb %dl, %r10b
    movq %r10, %rdx
    movb %dl, %al
    movb $3, %r9b
    idivb %r9b, %al
    subb %al, %cl
    cmpb $100, %cl
    jg percent
    cmpb $0, %cl
    js zero
    movq %rcx, %rax
    jmp end

percent:
    movq $100, %rax
    jmp end

zero:
    movq $0, %rax
    jmp end
    
end:  
    ret