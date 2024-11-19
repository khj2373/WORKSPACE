import React from "react";
import { Todo } from "./Types";

export const TodoStateContext = React.createContext<Todo[] | null>(null);
export const TodoDispatchContext = React.createContext<{
    onClickAdd: (text: string) => void;
    onClickRemove: (id: number) => void;
} | null>(null);