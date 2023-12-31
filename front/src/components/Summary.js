import { SummaryItem } from './SummaryItem';
import React, { useState } from 'react';

export function Summary({ items = [], onOrderSubmit }) {
    const totalPrice = items.reduce((prev, curr) => prev + curr.price * curr.count, 0);
    const [order] = useState();
    const handleSubmit = (e) => {
        onOrderSubmit(order);
    };
    return (
        <>
            <div>
                <h5 className="m-0 p-0">
                    <b>Summary</b>
                </h5>
            </div>
            <hr />
            {items.map((v) => (
                <SummaryItem key={v.productId} count={v.count} productName={v.productName} />
            ))}
            <form>
                <div>상품을 추가해주세요~</div>
                <div>당일 오후 2시 이후의 주문은 다음날 배송을 시작합니다.</div>
            </form>
            <div className="row pt-2 pb-2 border-top">
                <h5 className="col">총금액</h5>
                <h5 className="col text-end">{totalPrice}원</h5>
            </div>
            <button className="btn btn-dark col-12" onClick={handleSubmit}>
                결제하기
            </button>
        </>
    );
}
