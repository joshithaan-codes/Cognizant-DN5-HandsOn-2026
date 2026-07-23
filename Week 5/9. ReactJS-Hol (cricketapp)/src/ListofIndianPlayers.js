function ListofIndianPlayers(props) {

    return (
        <div>
            {
                props.IndianPlayers.map((player, index) => (
                    <li key={index}>
                        Mr. {player}
                    </li>
                ))
            }
        </div>
    );
}

export default ListofIndianPlayers;