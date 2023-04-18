.section .text
.global sens_velc_vento
sens_velc_vento:
    addq %rsi, %rdi
    movq %rdi, %rax
    cmpb $0, %al
    js negative
    jmp end

negative:
    movq $0, %rcx
    movq $0, %r10
    subb %al, %r10b
    addb %r10b, %cl
    movq %rcx, %rax
end:
    ret
    