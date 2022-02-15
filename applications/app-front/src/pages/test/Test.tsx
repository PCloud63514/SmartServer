import React from 'react'
import { CrossBox, TemplateBox } from "../../components/molecules";

// compo Header

// compo content
// compo A
// compo B
// compo C

// compo bottom

function Test() {
    return (
        <div style={{
            margin: 10,
            width: 520,
            height: 30
        }}>
            <span style={{
                width: 520,
                height: 30
            }}>
                <TemplateBox
                    style={{
                        width: "10em",
                        height: "10em",
                        backgroundColor: "skyblue"
                    }}
                >

                </TemplateBox>
            </span>
        </div>
    )
}

export default Test;
