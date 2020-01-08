import {RoleType} from '../enums/role-type.enum';

export class Account {
  constructor(
    public id: number,
    public name: string,
    public surname: string,
    public email: string,
    public password: string,
    public birthday: string,
    public registryTime: string,
    public role: RoleType
  ) {
  }
}

