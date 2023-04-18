
.section .text
.global sens_temp
sens_temp:
movsbq %dil, %rax
movsbq %sil, %rdx

    addq %rdx, %rax

    cmpq $40, %rax
    jg is_great
    cmpq $0, %rax
    jl is_less
    jmp end

    is_great:
    movq $40, %rax
    je end

    is_less:
    movq $0, %rax
    je end
 

end:



    ret