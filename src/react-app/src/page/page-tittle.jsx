import { useEffect, useState } from "react";
import { useLocation } from "react-router";
import { RouteAttribute } from "../util/constant.ts";

const PageTittle = () => {
    const location = useLocation();
    const [firstTittle, setFirstTittle] = useState('');
    const [secondTittle, setSecondTittle] = useState('');

    useEffect(() => {
        const route = RouteAttribute.find( ra => ra.path === location.pathname);
        setFirstTittle(route.title.first)
        setSecondTittle(route.title.second);
    }, [location]);

    return (
        <div className="nk-main">
            <div className="nk-gap-1"></div>
            <div className="container">
                <h3 className="nk-decorated-h-3">
                    <span>
                        <span className="text-main-1">{firstTittle} </span>{secondTittle}
                    </span>
                </h3>
            </div>
            <div className="nk-gap-1"></div>
        </div>
    )
};

export default PageTittle;