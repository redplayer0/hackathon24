export class UserLogIn {

  constructor(
    public email: string = "",
    public password: string = "",

  ) {}
}


export interface IUser {
  id: number;
  email: string;
  password: string;
  role: string;
}

export interface IUserLogin {
  email: string;
  password: string;
}
export class CustomerSingUp{
  constructor(
    public email: string = "",
    public password: string = "",
    public role: string = "",
    public vat: number = 0,
    public firstname: string  = "",
    public lastname:string = "",
    public birthday:string = "",
    public birthaddress:string = "",
    public weeklytransfer:number = 0,
    public weeklylimit:number = 0,
  ){}
}

export class ShopperSingUp{
  constructor(
    public email: string = "",
    public password: string = "",
    public role: string = "",
    public vat: number = 0,
    public shopname: string  = "",
    public birthaddress:string = "",
    
  ){}
}
export interface TransactionOfUser{
  transactionid: number,
  sourceaccount: string,
  targetaccount: string,
  status:string,
  amount: number,
  datetime: string
}




export interface Shop {
  vat: number
  name: string
  address: string
  creationdate: string
  deletiondate: string
  balance : number
  picture: string
  userid: number
}
