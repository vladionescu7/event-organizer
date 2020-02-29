export interface IUser {
    id: number;
    username: string;
    firstName: string;
    lastName: string;
    password: string;
    email: string;
}

export class User implements IUser {
    constructor(
        public id: number = null,
        public username: string = '',
        public firstName: string = '',
        public lastName: string = '',
        public password: string = '',
        public email: string= ''
    ) { }
}
