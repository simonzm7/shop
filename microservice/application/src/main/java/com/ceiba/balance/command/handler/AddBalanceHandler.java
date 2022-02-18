package com.ceiba.balance.command.handler;

import com.ceiba.balance.command.BalanceCommand;
import com.ceiba.balance.command.factory.BalanceFactory;
import com.ceiba.balance.service.AddBalanceService;
import com.ceiba.handler.CommandHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddBalanceHandler implements CommandHandler<BalanceCommand> {

    private final AddBalanceService addBalanceService;
    private final BalanceFactory balanceFactory;

    @Override
    public void execute(BalanceCommand command) {
        this.addBalanceService.execute(this.balanceFactory.toBalance(command));
    }
}
