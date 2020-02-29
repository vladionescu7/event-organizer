
import { User } from './user';
import { Access } from './access';
export interface IEvent {
    name: string;
    address: string;
    date: string;
    organiser: User;
    organiserId: number;
    access: Access;
}

export class Event implements IEvent {
    constructor(
        public name: string = '',
        public address: string = '',
        public date: string = '',
        public organiser: User = null,
        public organiserId: number = 0,
        public access: Access = null

    ) {}

}
