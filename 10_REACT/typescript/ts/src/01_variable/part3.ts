//타입 별칭부여

type User = {
    user_id: number,
    id: string,
    password: string,
    age: number,
    address: string
}

let user1 : User = {
    user_id: 1,
    id: "user01",
    password: "pass01",
    age: 20,
    address: "경기도 평택"
}

function test(){
    type Id = string;
    let user02: Id = "user02";
}

type SidoCode = {
    [key: string] : string; //key, value를 모두 string으로 정의하겠다
    seoul : string; //key가 seoul인 값이 필수이며 string으로 정의하겠다
}

let sidoCodeList: SidoCode = {
    "경기도" : "k1",
    "전라도" : "j1",
    "충청도" : "c1",
    "seoul" : "s1"
}