export interface Checkbook {
  id: number;
  status: string;
  account: {
    id: number;
    accountNumber: string;
    accountType: string;
    user: {
      username: string;
    };
  };
}
  