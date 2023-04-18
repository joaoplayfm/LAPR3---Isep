.section .text
.global sens_dir_vento
sens_dir_vento:
    movq %rdi, %rax
    movq %rsi, %rcx
    addq %rcx, %rax
    movw $360, %dx
    cmpw $360,%ax
    jg greater
    cmpw $0, %ax
    jl lower
    jmp end

greater:
    subw %dx, %ax
    jmp end

lower:
    addw %dx, %ax

    jmp end

end:

    ret
