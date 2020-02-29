
import { User } from './user';
import { Access } from './access';
export interface IEvent {
    name: string;
    address: string;
    date: Date;
    organiser: User;
    access: Access;
}

export class Event implements IEvent {
    constructor(
        public name: string = '',
        public address: string = '',
        public date: Date = null,
        public organiser: User = null,
        public access: Access = null

    ) {}
}
