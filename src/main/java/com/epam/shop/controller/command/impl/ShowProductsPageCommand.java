//package com.epam.shop.controller.command.impl;
//
//import com.epam.shop.controller.command.api.Command;
//
//
//
//public class ShowProductsCommand implements Command {
//    public static Command command;
//
//
//    private ShowProductsCommand() {
//    }
//
//    public static Command getInstance() {
//        if (command == null) {
//            command = new ShowProductsCommand();
//        }
//        return command;
//    }
//
//
//    @Override
//    public ClientResponseContext execute(ClientRequestContext requestContext) {
//        return null;
//    }
//}
