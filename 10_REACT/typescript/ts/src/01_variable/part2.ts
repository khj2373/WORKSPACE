//배열
let numArr: number[] = [1, 2, 3];

let strArr1: string[] = ["my", "name", "is"];

let strArr2: Array<string> = ["my", "name", "is"];

//배열에 들어가는 타입이 두가지 이상이다.
let multiArr: (string | number)[] = [10, "khj", 20];

//튜플
let tup1: [number, string, number] = [10, "two", 30];

//객체
// let user = {
//     name: "khj",
//     age: 20,
//     address: "경기도 평택시"
// }

let user: {
    name: string,
    age: number,
    address?: string // ?: 선택적 속성(없을 수도 있음을 나타냄)
} = {
    name: "khj",
    age: 20,
    // address: "경기도 평택시"
}

let math: {
    readonly pi: number // 읽기만 가능 변경불가
} = {
    pi: 3.14
}