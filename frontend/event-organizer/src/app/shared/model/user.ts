export interface IUser {
    username: string;
    firstName: string;
    lastName: string;
    password: string;
    email: string;
}

export class User implements IUser {
    constructor(
        public username: string = '',
        public firstName: string = '',
        public lastName: string = '',
        public password: string = '',
        public email: string= ''
    ) { }
}
