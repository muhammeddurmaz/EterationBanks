package com.muhammed.eterationbank.mapper;

import com.muhammed.eterationbank.dto.BankAccountDTO;
import com.muhammed.eterationbank.model.BankAccount;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface BankAccountMapper extends EntityMapper<BankAccountDTO, BankAccount> {
}
